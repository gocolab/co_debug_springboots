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
    <button id="call_ajax">call ajax</button>
    <h3>success</h3>
    <div id="status">Status : </div>
    <div id="dataID">Datas : </div>
    <hr>
    <h3>error</h3>
    <div id="error_status">Status : </div>
    <div id="error_xhr">XHR : </div>
    <div id="error_error">Error : </div>
    <hr>
    <h3>complete</h3>
    <div id="complete_status">Status : </div>
    <hr>

    <script>
        // $(document).ready(function(){
        $(function () {
            $("#call_ajax").click(function () {
                // create progress bar
                $.ajax({
                    // request 
                    url: "/api/v1/requestParamsWithDB",
                    type: "POST",
                    data: { 'currentPage': 1, 'pageScale': 10 },
                    success: function (data, status) {
                        $("#status").append(status);
                        // $('#dataID').append(typeof data);
                        // 하나 하나 확인 표시
                        // $('#dataID').append(data.paginations.blockScale);
                        // $('#dataID').append(', ');
                        // $('#dataID').append(data.resultList[1].NAME);
                        // $('#dataID').append(', ');
                        // each
                        $.each(data.resultList, function (index, item) {
                            $('#dataID').append('<div>' + index + ', ' + item.NAME + '</div>');
                        });
                    },
                    error: function (xhr, status, error) {
                        $("#error_status").append(status);
                        $('#error_xhr').append(typeof xhr);
                        $('#error_error').append(error);
                    },
                    complete: function () {
                        // remove progress bar
                        $("#complete_status").append("Done!");
                    },
                });
            });
        });
    </script>
</body>

</html>