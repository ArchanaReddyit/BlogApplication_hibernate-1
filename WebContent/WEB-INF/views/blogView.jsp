<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Wall</title>
<link rel="stylesheet" href="./css/blog.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
	 <nav>
        <img src="./assets/logo.svg" alt="logo" />
        <ul>
           <li> <a href="${pageContext.request.contextPath}/myblogs">My Blogs</a></li>
        	 <li> <a href="${pageContext.request.contextPath}/allblogs">All Blogs</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
         </ul>
    </nav>
    <div class="body-div1">
        <div>Your Blog Posts</div>
  <a href="${pageContext.request.contextPath}/new">  <button class="button" id="addBlog" ><i class="fas fa-plus-circle"></i>Add New Post</button></a>  
	</div>

<div class="body-div2">
<c:forEach var ="blog" items="${listBlog}">
	<div class="article-card">
	<img alt="" src="./assets/java card image.svg">
	<div class ="card-test">
	<h1 id="blog-title"> <c:out value="${blog.getBlogTitle()}" /></h1>
	<p id="blog-description"><c:out value="${blog.getBlogDescription()}"/></p>
	<p>Posted on <b><c:out value="${blog.getPostedOn()}"/></b></p>
	</div>
	<div class="card-buttons">
	<a href="edit?id=<c:out value='${blog.getBlogId()}'/>"><button type="button" id="edit">EDIT</button></a><a href="delect?id=<c:out value='${blog.getBlogId()}'/>"><button type="button" id="delete">DELETE</button></a>
	    </div>
	</div>
	</c:forEach>
</div>

<div class="body-div3">
<h1>${message}</h1>
</div>

</body>
</html>