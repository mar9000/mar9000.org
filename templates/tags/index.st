<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
  <h2>Tags</h2>
  
  $siteTags:{tag |
    <a class="btn btn-info" href="$tag$.html" role="button">$tag$</a> &nbsp;·
  }$
  
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
