<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>

<body>
    <div>Ajax Return HellowController</div>
    <div id="status">Status : </div>
    <div id="dataID">Datas : </div>

    <script>
        // $(document).ready(function(){
        $(function () {
            $.ajax({
                // request 
                url: "/api/v1/helloworld",
                type: "GET",
                success: function (data, status) {
                    $("#status").append(status);
                    $('#dataID').append(data);
                },
            });
        });
    </script>
</body>

</html>