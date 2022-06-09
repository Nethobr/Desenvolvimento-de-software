calcCumpom = (val, cumpom) => {
    var total = Number(val);
    var cup = Number (cumpom);
    var calc = Number((total * cup) / 100);
    return val - calc;
}

calcChashback = (valCumpom, cashBack, val) => {
    var cumpom = Number(valCumpom);
    var total = Number(val);
    var cash = Number(cashBack);
    var calc = Number(cumpom - ((total * cash) / 100));
    return total - (total - calc);
}

calcParcelado = (val, qtdParcelas) => {
    var total = Number(val);
    var parcelas = Number(qtdParcelas);

    return total / parcelas;
}

parcelado = () => {
    var teste = Number(document.getElementById("parcelado").value);

    var form = document.getElementById("pagamentoParcelado");

    if (teste == 1) {
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}

hoverDivs = () => {
    var formAvista = document.getElementById("pagamentoParcelado");
    formAvista.style.display = "none";
}

gerarPost = () => {
    // Var do post final
    var resCondicao = document.getElementById("resCondicao");
    var resTitulo = document.getElementById("resTitulo");
    var resConfigs = document.getElementById("resConfigs");

    var resCupom = document.getElementById("resCupom");
    var resValCheio = document.getElementById("resValCheio");
    var resCupomCacl = document.getElementById("resCupomCacl");
    var resCash = document.getElementById("resCash");
    var resParcelado = document.getElementById("resParcelado");

    var resComentario = document.getElementById("resComentario");
    var resLink = document.getElementById("resLink");

    // Valores do input
    var condicao = document.getElementById("condicao").value;
    var titulo = document.getElementById("titulo").value;
    var configs = document.getElementById("configs").value;

    var cupom = document.getElementById("cupom").value;
    var perCupom = Number(document.getElementById("perCupom").value);
    var cashback = document.getElementById("cashback").value;
    var perCash = Number(document.getElementById("perCash").value);
    var valCheio = document.getElementById("valCheio").value.replace(".", "");
    var val = parseFloat(valCheio.replace(",", "."));
    var parcelado = Number(document.getElementById("parcelado").value);
    var qtdParcelas = Number(document.getElementById("qtdParcelas").value);
    var condiParcelado = document.getElementById("condiParcelado").value;

    var comentario = document.getElementById("comentario").value;
    var link = document.getElementById("link").value;

    if (condicao)
        resCondicao.innerHTML = ("<p>⭐ " + condicao + " ⭐</p>");

    if (titulo)
        resTitulo.innerHTML = ("<p>🔥 " + titulo + " 🔥</p>");

    if (configs)
        resConfigs.innerHTML = ("<p>🔴" + configs + "🔴</p>");

    var cupomVal = Number(calcCumpom(val, perCupom));
    if (cupom)
        resCupom.innerHTML = ("🎟️ CUPOM: " + cupom + " - " + perCupom + "%<br>");
    if (valCheio)
        resValCheio.innerHTML = ("💸 R$ " + val.toFixed(2) + " (Valor cheio)<br>");
        resCupomCacl.innerHTML = ("💰 R$ " + cupomVal.toFixed(2) + " (Com cupom) <br>");
        resCash.innerHTML = ("🤑 R$  " + calcChashback(cupomVal, perCash, val).toFixed(2) + " (Com cupom + Cashback: "+ cashback +" "+ perCash +"%)<br>");         
    if (parcelado == 1)
        resParcelado.innerHTML = ("😱 R$ "+ calcParcelado(val, qtdParcelas).toFixed(2) +" em " + qtdParcelas + "x "+ condiParcelado + ".<br><br>");   
    
    if (comentario)
        resComentario.innerHTML = ("<p>⭐ " + comentario + " ⭐</p>");

    if (link)
        resLink.innerHTML = ("<p>Link: " + link + "</p>");
}