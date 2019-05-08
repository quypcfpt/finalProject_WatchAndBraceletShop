
function ready(fn) {
    if (document.attachEvent ? document.readyState === "complete" : document.readyState !== "loading"){
        fn();
        //getListCategories();
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
}


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
            alert(error.message);
        },
        dataType: "json",
        contentType: "application/json"
    });
}

// function getListCategories() {
//     doAjax("/api/productcategoryactive", "GET", null, function (data) {
//         let productcates = data.listProductCategory;
//         $("#list-cates").empty();
//         $.each(productcates, function (index, cat) {
//             let tr = "<a href=\"#\">" + cat.name +"</a>";
//             $("#list-cates").append(tr);
//         });
//     }, function (error) {
//         console.log(error);
//     });
// }