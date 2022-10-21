function redirecionarCadastroFornecedor() {
    window.location.href = '/providercreate';
}

function redirecionarDelete(id) {
    window.location.href = '/home/deletar/' + id;
}

function redirecionarPut(id) {
    window.location.href = '/home/editar/' + id;
}
