<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <#--    reference our style sheet-->
    <link type="text/css"
          rel="stylesheet"
            <#--https://stackoverflow.com/questions/18095844/how-to-include-css-file-in-a-free-marker-template/49846423#49846423-->
          href="/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer RelationShip Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <#--        put new button: Add Customer-->
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false"
               class="add-button">
        <!--  add out html table here -->
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Email Address</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <#list allCustomers as customer>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td><a href="showFormForUpdate/${customer.id}">Update</a></td>
                    <td><a href="delete/${customer.id}"
                           onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
</html>