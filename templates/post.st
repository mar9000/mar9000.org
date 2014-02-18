<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
  <div class="row">
  
    <!-- Left.   -->
    <div class="col-sm-8 blog-main">
        <div class="blog-post">
        
          <h2 class="blog-post-title"> $title$ </h2>
          <!-- Author.   -->
          <div class="author-section">
            <p class="photo"> <img src="/images/ml.png" /> </p>
            <small> <p class="name"> Marco LOMBARDO<br/>
                                     $date$ </p> </small>
          </div> <p style="clear: both;" />
<!-- Abstract: should stay here because if indented a <pre> section does not shows correctly.   -->
$abstract$
<!-- Content.   -->
$content$
          
        </div> <!-- /.blog-post -->
    </div> <!-- /.blog-main -->
      
    <!-- Right.   -->
    <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
        <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
    </div><!-- /.blog-sidebar -->
    
  </div>   <!-- row.   -->
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
