<!DOCTYPE html>

<html lang="en">

<!-- Header.   -->
$header$

<!-- Content.   -->
<div class="container">
  <h2>Tags</h2>
  
  $siteTags:{tag |
    <a href="/tags/$tag$.html">$tag$</a> &nbsp;· 
  }$
  
</div>   <!-- /.container -->

<!-- Footer.   -->
$footer$
