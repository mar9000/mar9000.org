<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
  <div class="row">
  
    <div class="blog-main">
        <div class="blog-post">
    
    <!-- Title.   -->
    <h2 class="blog-post-title" style="float: left"> $post.title$ </h2>    
    <!-- Tags.   -->
    <div class="col-sm-3" style="float: right">
        <div class="sidebar-module sidebar-module-inset">
            <h4>Tags:</h4>
            <p>
            $tags: { tag |
              <a href="/tags/$tag$.html"><span class="label label-primary">$tag$</span></a>
            }$
            </p>
        </div>
    </div>
    <p style="clear: both;" />
          
<!-- Content.   -->
$content$
          
        </div> <!-- /.blog-post -->
    </div> <!-- /.blog-main -->
      
    
  </div>   <!-- row.   -->
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
