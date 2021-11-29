<%--
  Created by IntelliJ IDEA.
  User: ZARA
  Date: 19.11.2021
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h2 {
            text-align: center;
            padding-bottom: 10px;
        }

        .form-control {
            display: inline !important;
            width: 20% !important;
            transform: translateX(270px);
        }

        .btn {
            transform: translateY(-2px) translateX(270px);
        }

        #btn{
            transform:translateX(5px);
        }

        .table {
            width: 66.5% !important;
            transform: translateX(190px);
        }
    </style>
    <title>Todo list</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="//malsup.github.com/jquery.form.js"></script>

    <script>

        $(document).ready(function () {
            $("#save").click(function () {
                let name = $("#taskName").val();
                let description = $("#description").val();
                $.ajax({
                    url: "/api/todo/add",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({"name": name, "description": description}),
                    success: function (data) {
                        let i = 1;
                        if (data) {
                            let x = "<tr>" +
                                "<th scope='row'>" + data.id + "</th>" +
                                "<td>" + data.name + "</td>" +
                                "<td>" + data.description + "</td>" +
                                "<td>" + data.status + "</td>" +
                                "<td>" + data.createdAt + "</td>" +
                                "<td><button class='btn btn-outline-success' id='btn'>Do</button></td>"
                                + "</tr>"
                            $('#tBody').append(x);
                        }
                    },
                    error: function () {
                        $('#text').html("<p>Error</p>")
                    }
                });
            })

            $('#btn').click(function () {
                $('#tBody tr td').css("background-color","indigo");
            })
        })

    </script>

</head>
<body>

<div class="container mt-5">
    <h2> Todo list</h2>

    <input type="text" class="form-control" placeholder="taskName" id="taskName">
    <input type="text" class="form-control" placeholder="description" id="description">
    <button type="submit" class="btn btn-outline-dark" id="save">Save</button>
    <br>

    <div id="item">
        <table class="table table-striped table-bordered mt-3">
            <thead>
            <tr id="tr">
                <th scope="col">T/R</th>
                <th scope="col">Task name</th>
                <th scope="col">description</th>
                <th scope="col">Status</th>
                <th scope="col">Created At</th>
            </tr>
            </thead>
            <tbody id="tBody">

            </tbody>
        </table>
    </div>
    <div id="text">

    </div>
</div>

</body>
</html>
