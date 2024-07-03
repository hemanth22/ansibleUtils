// vars/ansibleUtils.groovy

def ansibleLint(script) {
  sh(
    script: "${script} | tee >> ansible_lint_error.txt"
  )
  def errors = readFile('ansible_lint_error.txt')
  return errors.split("\n")
}

def wget(url, output) {
  sh(
    script: "wget -O ${output} ${url}"
  )
}

def python3(script) {
  sh(
    script: "python3 ${script}"
  )
}

def appendText(text, file) {
  sh(
    script: "echo '${text}' >> ${file}"
  )
}
