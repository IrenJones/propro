<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">PaymentsApp</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav" style="float: none!Important;">
            <li><a href="/SpringWebwithSpringSecurity/user">Home</a></li>
            <li><a href="/SpringWebwithSpringSecurity/user/show_transactions">Show transactions</a></li>
            <li><a href="/SpringWebwithSpringSecurity/user/block">Manage My Bank Accounts</a></li>
            <li><a href="/SpringWebwithSpringSecurity/user/about">About</a></li>
            <li style="float:right;"><a href="/SpringWebwithSpringSecurity/logout">Logout</a></li>
            <li style="float:right;"><a href="/SpringWebwithSpringSecurity/user/settings">Hello, <%= request.getUserPrincipal().getName() %></a></li>
          </ul>
        </div>
  </div>
</div>
<br></br><br></br>