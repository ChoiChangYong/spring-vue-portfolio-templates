! function (e) {
    "use strict";
    new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"), e("#basicTableId").on("cell:edited")
}(jQuery);