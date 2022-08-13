*해당 프로젝트는 인텔리제이, 자바 11버전으로 작성되었습니다.

*instagram oEmbed 기능을 사용할 수 없는 이유
api 호출 시 아래와 같은 응답을 받습니다.
{
    "error": {
        "message": "(#200) Provide valid app ID",
        "type": "OAuthException",
        "code": 200,
        "fbtrace_id": "Ar0qne5GZzyHbMcq3ki7ukj"
    }
}
인스타그램(페이스북)은 별도로 인증받은 사용자에게만 api를 허용하고 있습니다.

참고: https://developers.facebook.com/docs/instagram/oembed


