package br.com.escolatcc.bean;

public class PessoaBean {

	private static int idPessoa;
	private static String nomePessoa;
	private static int nascimentoPessoa;
	private static int idEnderecoPessoa;
	private static int numero;
	private static String email;
	private static String sexo;
	private static int rg;
	private static int cpf;
	private static boolean aluno;
	private static boolean professor;
	private static boolean funcionario;
	private static int idConta;
	
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public int getNascimentoPessoa() {
		return nascimentoPessoa;
	}

	public void setNascimentoPessoa(int nascimentoPessoa) {
		this.nascimentoPessoa = nascimentoPessoa;
	}

	public int getIdEnderecoPessoa() {
		return idEnderecoPessoa;
	}

	public void setIdEnderecoPessoa(int idEnderecoPessoa) {
		this.idEnderecoPessoa = idEnderecoPessoa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public boolean isAluno() {
		return aluno;
	}

	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}

	public boolean isProfessor() {
		return professor;
	}

	public void setProfessor(boolean professor) {
		this.professor = professor;
	}

	public boolean isFuncionario() {
		return funcionario;
	}

	public void setAdministrador(boolean funcionario) {
		this.funcionario = funcionario;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

}
