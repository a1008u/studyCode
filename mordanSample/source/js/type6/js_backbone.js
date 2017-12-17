import * as Backbone from "backbone"

let NoteModel = Backbone.Model.extend (
    {
        initialize: function() {console.log("NoteModel initialized.")}
        , author: function() {}
        , coordinates : function() {}
        , allowedToEdit: function(account) {return true}
    }
)