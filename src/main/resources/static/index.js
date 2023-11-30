$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/books/100"
    }).then(function(data) {
       $('.book-id').append(data.id);
       $('.book-title').append(data.title);
       $('.book-genre').append(data.genre);
       $('.book-authorName').append(data.authorName.name);
    });
});