import $ from 'jquery'

! function (e) {
    "use strict";
    var t = "lte.tree",
        n = {
            animationSpeed: 500,
            accordion: !0,
            followLink: !1,
            trigger: ".treeview a"
        },
        i = ".treeview",
        o = ".treeview-menu",
        s = ".menu-open, .active",
        r = '[data-widget="tree"]',
        a = ".active",
        l = "menu-open",
        c = "tree",
        p = "collapsed.tree",
        d = "expanded.tree",
        h = function (t, n) {
            this.element = t, this.options = n, e(this.element).addClass(c), e(i + a, this.element).addClass(l), this._setUpListeners()
        };

    function f(i) {
        return this.each(function () {
            var o = e(this);
            if (!o.data(t)) {
                var s = e.extend({}, n, o.data(), "object" == typeof i && i);
                o.data(t, new h(o, s))
            }
        })
    }
    h.prototype.toggle = function (e, t) {
        var n = e.next(o),
            s = e.parent(),
            r = s.hasClass(l);
        s.is(i) && (this.options.followLink && "#" !== e.attr("href") || t.preventDefault(), r ? this.collapse(n, s) : this.expand(n, s))
    }, h.prototype.expand = function (t, n) {
        var i = e.Event(d);
        if (this.options.accordion) {
            var r = n.siblings(s),
                a = r.children(o);
            this.collapse(a, r)
        }
        n.addClass(l), t.slideDown(this.options.animationSpeed, function () {
            e(this.element).trigger(i)
        }.bind(this))
    }, h.prototype.collapse = function (t, n) {
        var i = e.Event(p);
        n.removeClass(l), t.slideUp(this.options.animationSpeed, function () {
            e(this.element).trigger(i)
        }.bind(this))
    }, h.prototype._setUpListeners = function () {
        var t = this;
        e(this.element).on("click", this.options.trigger, function (n) {
            t.toggle(e(this), n)
        })
    };
    var u = e.fn.tree;
    e.fn.tree = f, e.fn.tree.Constructor = h, e.fn.tree.noConflict = function () {
        return e.fn.tree = u, this
    }, e(window).on("load", function () {
        e(r).each(function () {
            f.call(e(this))
        })
    })
}($);