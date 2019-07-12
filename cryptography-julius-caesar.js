var xmlHttp = new XMLHttpRequest();
xmlHttp.open( "GET", "http://127.0.0.1:8887/answer.json", "false"); // synchronous
xmlHttp.send( null );
xmlHttp.onload = function(e) {
    var json = JSON.parse(xmlHttp.responseText);
    var charNumber = {};  // {'a':0, 'b':1, ''''}
    var numberChar = {};  // {0:'a', 1:'b', ...}
    var j = 0;
    for (var i=97; i<123; i++) {
        charNumber[String.fromCharCode(i)] = j;
        numberChar[j] = String.fromCharCode(i);
        j++;
    }
    j++;

    var charList = Array.from(json.cifrado); // ['d', 'f', '4', ...]
    var decifrado = "";
    for (var i=0; i<charList.length; i++) {
        n_char = charNumber[charList[i]];

        if (typeof n_char == typeof 1) {
            cn_char = n_char - json.numero_casas;
            if (cn_char < 0) {
                cn_char += (j - 1);
            }
            decifrado += numberChar[cn_char];
        } else {
            decifrado += charList[i];
        }
    }
    console.log(decifrado);
}

// echo -n "text" | shasum
// curl -H "Content-Type: multipart/form-data" -F "answer=@answer.json" https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=xxx
