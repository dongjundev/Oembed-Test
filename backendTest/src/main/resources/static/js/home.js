// 확인 버튼을 누르면 url을 받는다.
function dataSend() {

    var data=$("#urlText").val();

    $.ajax({
        url: "/oembedResponse?userUrlData="+encodeURI(data),
        type: "GET"
    }).done(function (fragment) {
        $("#content_wrap").replaceWith(fragment);
    });
}