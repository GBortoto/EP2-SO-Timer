n_files = 2:20
cor = "black"

titulo = "Medias"
png(filename=paste(titulo, ".png", sep=""), width=1920, height=1080)

arquivo = read.table("medias.txt")
data = arquivo$V1
plot(data, col=cor, main=titulo, xlab="Número de Escritores", ylab="Tempo (ns)")
lines(data, col=cor)

dev.off()