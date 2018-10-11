$(function() {
	$('#imagens ul').cycle({
		fx : "fade",
		speed : 1000,
		timeout : 2000

	});
})

$(document).ready(function() {
	$("button").click(function() {
		$("p").toggle();
	});
});

$(document).ready(function() {
	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").each(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});

function fonte(e) {
	var elemento = document.getElementById("conteudo");
	var atual = elemento.style.fontSize;

	if (e == 'a') {
		atual = parseInt(atual) + 2 + 'px';
	} else if (e == 'b') {
		atual = parseInt(atual) - 2 + 'px';
	} else if (e == 'c') {
		atual = 15 + 'px';
	}
	elemento.style.fontSize = atual;
}

function validarFormulario() {
	var elemento = document.getElementById("termo").checked;

	if (elemento == false) {
		alert("Não pode se cadastrar se não ler e concondar com o termo que corresponde ao seu tipo de perfil ");
		return false;
	}
	if (elemento == true) {
		return true;
	}
}


//Validação do CNPJ 

function FormataCnpj(campo, teclapres) {
	var tecla = teclapres.keyCode;
	var vr = new String(campo.value);
	vr = vr.replace(".", "");
	vr = vr.replace("/", "");
	vr = vr.replace("-", "");
	tam = vr.length + 1;
	if (tecla != 14) {
		if (tam == 3)
			campo.value = vr.substr(0, 2) + '.';
		if (tam == 6)
			campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 5) + '.';
		if (tam == 10)
			campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.'
					+ vr.substr(6, 3) + '/';
		if (tam == 15)
			campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.'
					+ vr.substr(6, 3) + '/' + vr.substr(9, 4) + '-'
					+ vr.substr(13, 2);
	}
}

function validarCNPJ(empresaCNPJ) {

	empresaCNPJ = empresaCNPJ.replace(/[^\d]+/g, '');

	if (empresaCNPJ == '')
		return false;

	if (empresaCNPJ.length != 14)
		return false;

	// Elimina CNPJs invalidos conhecidos
	if (empresaCNPJ == "00000000000000" || empresaCNPJ == "11111111111111"
			|| empresaCNPJ == "22222222222222" || empresaCNPJ == "33333333333333"
			|| empresaCNPJ == "44444444444444" || empresaCNPJ == "55555555555555"
			|| empresaCNPJ == "66666666666666" || empresaCNPJ == "77777777777777"
			|| empresaCNPJ == "88888888888888" || empresaCNPJ == "99999999999999")
		return false;

	// Valida DVs
	tamanho = empresaCNPJ.length - 2
	numeros = empresaCNPJ.substring(0, tamanho);
	digitos = empresaCNPJ.substring(tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(0))
		return false;

	tamanho = tamanho + 1;
	numeros = empresaCNPJ.substring(0, tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(1))
		return false;

	return true;

}
