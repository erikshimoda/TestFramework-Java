$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Servicos API/Api.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    },
    {
      "line": 2,
      "value": "#encoding: iso-8859-1"
    }
  ],
  "line": 6,
  "name": "Acessar uma API e realizar uma requisiÃ§Ã£o",
  "description": "",
  "id": "acessar-uma-api-e-realizar-uma-requisiã§ã£o",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 4,
      "name": "@servicos"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 9,
  "name": "que eu realizo um request para a API \"http://jsonplaceholder.typicode.com\"",
  "keyword": "Dado "
});
formatter.match({
  "arguments": [
    {
      "val": "http://jsonplaceholder.typicode.com",
      "offset": 38
    }
  ],
  "location": "PostsApiSteps.que_eu_realizo_um_request_para_a_api(String)"
});
formatter.result({
  "duration": 376222982,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Realizar um POST request na API no caminho /posts, devo visualizar um post",
  "description": "",
  "id": "acessar-uma-api-e-realizar-uma-requisiã§ã£o;realizar-um-post-request-na-api-no-caminho-/posts,-devo-visualizar-um-post",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 12,
  "name": "eu realizo um GET request com o caminho \"/posts/1\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "eu recebo codigo \"200\" como resposta",
  "keyword": "Entao "
});
formatter.step({
  "line": 14,
  "name": "eu recebo a resposta:",
  "rows": [
    {
      "cells": [
        "userId",
        "id"
      ],
      "line": 15
    },
    {
      "cells": [
        "1",
        "1"
      ],
      "line": 16
    }
  ],
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "/posts/1",
      "offset": 41
    }
  ],
  "location": "PostsApiSteps.eu_realizo_um_GET_request_com_o_caminho(String)"
});
formatter.result({
  "duration": 4394257831,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 18
    }
  ],
  "location": "PostsApiSteps.eu_recebo_codigo_como_resposta(int)"
});
formatter.result({
  "duration": 40469537,
  "status": "passed"
});
formatter.match({
  "location": "PostsApiSteps.eu_recebo_a_resposta(PostsApiBean\u003e)"
});
formatter.result({
  "duration": 13320541,
  "status": "passed"
});
});