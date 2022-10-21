
function redirecionarlogin() {
    window.location.href = '/userlogin';
}

function redirecionarcadastro() {
    window.location.href = '/usercreate';
}

function conferepassword() {
    const password = document.querySelector('input[name=password]');
    const confirma = document.querySelector('input[name=confirma]');

    if (confirma.value === password.value) {
        confirma.setCustomValidity('');
    } else {
        confirma.setCustomValidity('As senhas não estão iguais')
    }
}