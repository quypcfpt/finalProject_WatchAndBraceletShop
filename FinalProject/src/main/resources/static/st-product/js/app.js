
function doAjax(url, method, data, callback, onError) {
    $.ajax({
        url: url,
        type: method,
        data: JSON.stringify(data),
        success: function (response) {
            if (response.status) {
                callback(response);
            } else {
                //showAlert(false, response.message);
                alert(response.message);
            }
        },
        error: function (xhr, status, error) {
            alert(response.message);
        },
        dataType: "json",
        contentType: "application/json"
    });
}