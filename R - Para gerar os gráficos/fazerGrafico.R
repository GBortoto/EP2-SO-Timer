n_files = 2:20
cor = "black"

titulo = paste(toString(length(n_files)+1), "x Opção 1")
png(filename=paste(titulo, ".png", sep=""), width=1920, height=1080)

arquivo = read.table("data1.txt")
data = arquivo$V1
plot(data, col=cor, main=titulo, xlab="Número de Escritores", ylab="Tempo (ns)")
lines(data, col=cor)

for(i in n_files){
	nome = paste("data", toString(i), sep="")
	nome = paste(nome, ".txt", sep="")
	arquivo = read.table(nome)
	data = arquivo$V1
	points(data, col=cor)
	lines(data, col=cor)
}

dev.off()