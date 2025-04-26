#!/bin/bash

# Caminhos
JAR_NAME="app-0.0.1-SNAPSHOT.jar"
PROJECT_DIR="/var/www/WhippedBeerSpring"
TARGET_JAR="$PROJECT_DIR/target/$JAR_NAME"
DEPLOY_JAR="/opt/whippedbeer/app.jar"

echo "🚀 Iniciando processo de deploy..."

# Etapa 1: Build do projeto
echo "📦 Compilando projeto com Maven (sem testes)..."
cd "$PROJECT_DIR" || exit 1
./mvnw clean package -DskipTests

# Verifica se o .jar foi criado
if [ ! -f "$TARGET_JAR" ]; then
  echo "❌ Arquivo $JAR_NAME não encontrado em $TARGET_JAR"
  exit 1
fi

# Etapa 2: Copia o .jar para o destino
echo "📁 Copiando $JAR_NAME para $DEPLOY_JAR"
sudo cp "$TARGET_JAR" "$DEPLOY_JAR"

# Etapa 3: Reinicia o serviço
echo "🔁 Reiniciando serviço whippedbeer..."
sudo systemctl restart whippedbeer

# Etapa 4: Mostra status
echo "📋 Status do serviço:"
sudo systemctl status whippedbeer --no-pager

# Etapa 5: Sugestão de monitoramento ao vivo
echo ""
echo "👀 Use os comandos abaixo para acompanhar os logs:"
echo "  🔧 journalctl -u whippedbeer -f"
echo "  🌐 tail -f /var/log/nginx/grmtechs/api-whippedbeer-access.log"

echo ""
echo "✅ Deploy concluído!"
