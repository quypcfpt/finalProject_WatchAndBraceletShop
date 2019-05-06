const configuration = {
    SIGNATURE: "6b14fbe0522b8c8b18cd7b64c2e5249c0388117f4d91f8773d1e0334727bde72",
    POLICY: "eyJleHBpcnkiOjE1NjQ1OTA2MDAsImNhbGwiOlsicGljayIsInJlYWQiLCJzdGF0Iiwid3JpdGUiLCJ3cml0ZVVybCIsInN0b3JlIiwicmVtb3ZlIl0sIm1pblNpemUiOjEyOCwibWF4U2l6ZSI6MTAyNDAwMH0=",
    APIKEY: "ALBSfS3M1T7C2AGUh7VLgz"
}
// var regexpass = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
var regexEmail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;


function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();
    hour = '' + d.getHours();
    mins = '' + d.getMinutes();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    date = [day, month, year].join('/');
    hour = [hour, mins].join(":");
    return date + " " + hour;
}

function toDate(selector) {
    if (selector == "" || selector == undefined) {
        return "";
    }

    var from = selector.split("/");

    return Date.parse(from[1] + "/" + from[0] + "/" + from[2]);
}

function minDateTimeStart() {
    var current = new Date();
    current.setMinutes(current.getMinutes() + 3);
    return current;
} 

function errorToast(title, msg) {
    $.toast({
        heading: title,
        text: msg,
        position: 'top-right',
        loaderBg: '#ffff',
        icon: 'error',
        hideAfter: 3500
    });
}