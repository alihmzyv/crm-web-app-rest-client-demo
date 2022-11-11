<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css"
            rel="stylesheet"
            href="/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
<h3>Save Customer</h3>
    <form action="/customers/saveCustomer" method="post">
        <@spring.formHiddenInput path="customer.id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td>
                    <@spring.formInput path="customer.firstName"/>
                    <@spring.showErrors "<br>"/><br>
                </td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td>
                    <@spring.formInput path="customer.lastName"/>
                    <@spring.showErrors "<br>"/>
                </td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td>
                    <@spring.formInput path="customer.email"/>
                    <@spring.showErrors "<br>"/><br>
                </td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear: both" ></div>
    <p>
        <a href="list">Back to List</a>
    </p>
</div>
</body>
</html>