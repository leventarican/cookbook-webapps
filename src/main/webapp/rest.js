var xmlhttp;
function init() {
    console("calling init()");
    xmlhttp = new XMLHttpRequest();
}
function getResults() {
    console("calling getResult()");
    var url = "http://localhost:8080/webapp0/resources/numbers";
    xmlhttp.open('GET', url, true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200)
                console("Success -> " + xmlhttp.responseText);
            else
                console("Error -> " + xmlhttp.responseText);
        }
    };
}

init();
getResults();