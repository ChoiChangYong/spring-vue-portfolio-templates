import $ from 'jquery'

window.onload = function () {
    if (!window.$) throw "jQuery is not loaded"
};
class SimpleTableCellEdition {
    constructor(e, t) {
        this.Elem = e, this.oldContent = $(e).html(), this.oldValue = t.internals.extractValue(e), this.cellParams = t
    }
}
export default class SimpleTableCellEditor {
    constructor(e, t) {
        var l = this;
        l.EditionEndOrigin = {
            OutsideTable: 1,
            AnotherCell: 2
        }, void 0 === e && (e = "table"), this.tableId = e, this.params = l._GetExtendedEditorParams(t), this.CellEdition = null, this._TryHandleDataTableReloadEvent(), $(document).mouseup(function (e) {
            var t = $(`#${l.tableId}`);
            t.is(e.target) || 0 !== t.has(e.target).length || l._FreeCurrentCell(l.EditionEndOrigin.OutsideTable)
        })
    }
    SetEditable(e, t) {
        var l = this;
        if (l._isValidElem(e)) {
            var i = l._GetExtendedCellParams(t);
            $(e).on("click", function () {
                $(this).hasClass(l.params.inEditClass) || l._EditCell(this, i)
            }), $(e).on("keydown", function (e) {
                $(this).hasClass(l.params.inEditClass) && l._HandleKeyPressed(e.which, this, i)
            })
        }
    }
    SetEditableClass(e, t) {
        var l = this,
            i = l._GetExtendedCellParams(t);
        $(`#${this.tableId}`).on("click", `td.${e}:not(.${l.params.inEditClass})`, function () {
            l._EditCell(this, i)
        }), $(`#${this.tableId}`).on("keydown", `td.${e}.${l.params.inEditClass}`, function (e) {
            l._HandleKeyPressed(e.which, this, i)
        })
    }
    _HandleKeyPressed(e, t, l) {
        l.keys.validation.includes(e) ? this._FreeCell(t, l, !0) : l.keys.cancellation.includes(e) && this._FreeCell(t, l, !1)
    }
    _EditCell(e, t) {
        if (!this._FireOnEditEnterEvent(e).isDefaultPrevented()) {
            this._FreeCurrentCell(this.EditionEndOrigin.AnotherCell), this.CellEdition = new SimpleTableCellEdition(e, t), this.isDataTable && (this.CellEdition.cellIndex = $(`#${this.tableId}`).DataTable().cell($(e)).index());
            var l = t.internals.extractValue(e);
            $(e).addClass(this.params.inEditClass), t.internals.renderEditor(e, l), this._FireOnEditEnteredEvent(e, l)
        }
    }
    _EndEditCell(e, t) {
        this._FreeCell(e, t, !0)
    }
    _CancelEditCell(e, t) {
        this._FreeCell(e, t, !1)
    }
    _FreeCell(e, t, l) {
        if (this._isValidElem(e) && null !== this.CellEdition && !this._FireOnEditExitEvent(e, this.CellEdition.oldValue).isDefaultPrevented()) {
            var i = t.internals.extractEditorValue(e);
            $(e).removeClass(this.params.inEditClass), $(e).html("");
            var a = t.formatter(i);
            t.validation(i) && this.CellEdition.oldValue !== a || (l = !1), this._FireOnEditExitedEvent(e, this.CellEdition.oldValue, a, l), l ? (t.internals.renderValue(e, a), this._FireEditedEvent(e, this.CellEdition.oldValue, a)) : $(e).html(this.CellEdition.oldContent), this.CellEdition = null
        }
    }
    _FreeCurrentCell(e) {
        var t = this._GetCurrentEdition();
        if (null !== t) {
            var l = !0;
            e === this.EditionEndOrigin.OutsideTable && t.cellParams.behaviour.outsideTableClickCauseCancellation && (l = !1), e === this.EditionEndOrigin.AnotherCell && t.cellParams.behaviour.anotherCellClickCauseCancellation && (l = !1), this._FreeCell(t.Elem, t.cellParams, l)
        }
    }
    _GetCurrentEdition() {
        return null === this.CellEdition ? null : this.CellEdition
    }
    _GetExtendedEditorParams(e) {
        return $.extend(!0, {}, this._GetDefaultEditorParams(), e)
    }
    _GetExtendedCellParams(e) {
        return $.extend(!0, {}, this._GetDefaultCellParams(), e)
    }
    _FireOnEditEnterEvent(e) {
        var t = $.Event("cell:onEditEnter", {
            element: e
        });
        return $(`#${this.tableId}`).trigger(t), t
    }
    _FireOnEditEnteredEvent(e, t) {
        $(`#${this.tableId}`).trigger({
            type: "cell:onEditEntered",
            element: e,
            oldValue: t
        })
    }
    _FireOnEditExitEvent(e, t) {
        var l = $.Event("cell:onEditExit", {
            element: e,
            oldValue: t
        });
        return $(`#${this.tableId}`).trigger(l), l
    }
    _FireOnEditExitedEvent(e, t, l, i) {
        $(`#${this.tableId}`).trigger({
            type: "cell:onEditExited",
            element: e,
            newValue: l,
            oldValue: t,
            applied: i
        })
    }
    _FireEditedEvent(e, t, l) {
        $(`#${this.tableId}`).trigger({
            type: "cell:edited",
            element: e,
            newValue: l,
            oldValue: t
        })
    }
    _TryHandleDataTableReloadEvent() {
        var e = this;
        this.isDataTable = !1;
        try {
            $.fn.DataTable.isDataTable(`#${e.tableId}`) && (e.isDataTable = !0)
        } catch (e) {
            return
        }
        e.isDataTable && $(`#${e.tableId}`).on("draw.dt", function () {
            if (null !== e.CellEdition && null !== e.CellEdition.Elem) {
                var t = $(`#${e.tableId}`).DataTable().cell(e.CellEdition.cellIndex).node();
                e._EditCell(t, e.CellEdition.cellParams)
            }
        })
    }
    _GetDefaultEditorParams() {
        return {
            inEditClass: "inEdit"
        }
    }
    _GetDefaultCellParams() {
        return {
            validation: () => !0,
            formatter: e => e,
            keys: {
                validation: [13],
                cancellation: [27]
            },
            behaviour: {
                outsideTableClickCauseCancellation: !1,
                anotherCellClickCauseCancellation: !1
            },
            internals: this._GetDefaultInternals()
        }
    }
    _GetDefaultInternals() {
        return {
            renderValue: (e, t) => {
                $(e).text(t)
            },
            renderEditor: (e, t) => {
                $(e).html("<input type='text' style=\"width:100%; max-width:none\">");
                var l = $(e).find("input");
                l.focus(), l.val(t)
            },
            extractEditorValue: e => $(e).find("input").val(),
            extractValue: e => $(e).text()
        }
    }
    _isValidElem(e) {
        return null != e && $(e).length > 0
    }
}