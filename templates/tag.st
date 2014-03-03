<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
  <div class="row">
    <div class="col-md-9"><h2>tagged by: $tag$</h2></div>
  </div>
  
  <dl class="dl-horizontal">
    $posts:{post |
    <dt>$post.dateString$</dt>
    <dd><b><a href="/bliki/$post.url$">$post.title$</a></b><br/> $post.summary$ </dd>
    }$
  </dl>
  
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
