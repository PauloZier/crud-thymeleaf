function foneMask(idInput) {

    var input = document.getElementById(idInput);

    var tel = removeMask(input.value);

    switch (tel.length) {

        case 10:
            input.value = tel.replace(/(\d{2})(\d{4})(\d{4})/, '($1) $2-$3');
            break;

        case 11:
            input.value = tel.replace(/(\d{2})(\d{1})(\d{4})(\d{4})/, '($1) $2 $3-$4');
            break;

    }
}

function cepMask(idInput) {

    var input = document.getElementById(idInput);

    var cep = removeMask(input.value);

    if (cep.length == 8)
        input.value = cep.replace(/(\d{5})(\d{3})/, '$1-$2');
}

function removeMask(str) {

    return str.replace(/[^0-9a-zA-Zà-úÀ-Ú]/g, '').replace(' ', '');
}

function somenteDigitos(e) {

    var charCode = e.charCode ? e.charCode : e.keyCode;

    if (charCode != 8 && charCode != 9) {

        if (charCode < 48 || charCode > 57) {
            return false;
        }
    }

    return true;
}

function adicionarEventoSomenteDigito(idInput) {

    const input = document.getElementById(idInput);

    input.addEventListener('keypress', (evt) => {

        if (!somenteDigitos(evt))
            evt.preventDefault();
    });
}

function adicionarEventosCampoFone(idInput) {

    const fone = document.getElementById(idInput);

    fone.addEventListener('keypress', (evt) => {

        if (!somenteDigitos(evt))
            evt.preventDefault();
    });

    fone.addEventListener('focus', (evt) => {

        fone.value = removeMask(fone.value);
    });

    fone.addEventListener('blur', (evt) => {

        foneMask(idInput);
    });

}

function adicionarEventosCampoCep(idInput) {

    const cep = document.getElementById(idInput);

    cep.addEventListener('keypress', (evt) => {

        if (!somenteDigitos(evt))
            evt.preventDefault();
    });

    cep.addEventListener('focus', (evt) => {

        cep.value = removeMask(cep.value);
    });

    cep.addEventListener('blur', (evt) => {

        cepMask(idInput);
    });

}

function buscarEndereco(idCep, idLogradouro, idBairro, idCidade, idEstado) {

    var cep = document.getElementById(idCep).value;
    var endereco = document.getElementById(idLogradouro);
    var bairro = document.getElementById(idBairro);
    var cidade = document.getElementById(idCidade);
    var estado = document.getElementById(idEstado);

    $.ajax({
        url: 'https://viacep.com.br/ws/' + cep + '/json/',
        type: 'GET',
        success: function (result) {

            if (confirm('Deseja atualizar endereço com dados do Cep ?') && !result.erro) {
                endereco.value = result.logradouro;
                bairro.value = result.bairro;
                cidade.value = result.localidade;
                estado.value = result.uf;
            }

            $(function () {
                M.updateTextFields();
            });
        }
    });
}

function confirmarExclusao() {

    return confirm('Deseja mesmo excluir ?');
}
