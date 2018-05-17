document.addEventListener("DOMContentLoaded",function(){
	
	var ul = document.querySelector('ul.book');
	
	$.ajax({
		url: "http://localhost:8080/books/",
		type: "GET",
		dataType: "json"
	})
	.done( books => insertBooks(ul, books) );
	
	 var submit = document.querySelector('.btn');
		$(submit).on('click', function(event) {
			if(event.target.tagName == "BUTTON"){
				event.preventDefault();
				var title = document.getElementById("title").value;
				var author = document.getElementById("author").value;
				var isbn = document.getElementById("isbn").value;
			}
			$.ajax({
	    		url: "http://localhost:8080/books/",
	    		data: JSON.stringify({
	                "title" : title,
	                "author" : author, 
	                "isbn" : isbn}),
	    		contentType: "application/json",
	    		type: "POST",
	    		dataType: "json"
	    	})
	    	.done (function() { alert('POST completed'); location.reload();} )
			.fail (function() { alert('POST failed'); } );
		});
		
	var deleteButton = document.querySelector('.delete');
	$(ul).on('click', function(event) {
		if(event.target.classList == 'delete') {	
			var parent = event.target.parentElement;
			var id = parent.getAttribute("data-id");
			$.ajax({
				url: "http://localhost:8080/books/" + id,
				type: "DELETE",
			})
			.done( function() { alert('DELETE completed'); location.reload();} )
			.fail (function() { alert('DELETE failed'); } );
		}
	});
});



function insertBooks(listElem, books){
    books.forEach( book => {
    	let title = document.createElement('h3');
        title.innerText = book.title;
        let author = document.createElement('h3');
        author.innerText = book.author;
        let isbn = document.createElement('h3');
        isbn.innerText = book.isbn;
        let li = document.createElement('li');
        li.dataset.id=book.id;
        var deleteButton = document.createElement('button');
        deleteButton.innerText = 'delete';
        deleteButton.classList.add('delete');
        
        li.appendChild(title);
        li.appendChild(author); 
        li.appendChild(isbn);
        li.appendChild(deleteButton);
        
        listElem.appendChild(li);
    });
}


