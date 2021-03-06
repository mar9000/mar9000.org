<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
<!-- The original template was as follow:
      <div class="blog-header">
        <h1 class="blog-title">The Bootstrap Blog</h1>
        <p class="lead blog-description">The official example template of creating a blog with Bootstrap.</p>
      </div>
-->
  <div class="jumbotron blog-main">
    <h1>Just one more experiment!</h1>
    <p>Want to know how it is organized? <a href="/site-organization.html">Read more &raquo;</a></p>
  </div>
  
  <hr/>

  <div class="row">
    <div class="col-md-9"><h2>Blog posts</h2></div>
  </div>
  
  <dl class="dl-horizontal">
    $posts:{post |
    <dt>$post.dateString$</dt>
    <dd><b><a href="bliki/$post.url$">$post.title$</a></b><br/> $post.summary$ </dd>
    }$
  </dl>
  
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
