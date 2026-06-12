#!/bin/bash
# S.O. - Usuários e Grupos - Prática Completa

# ─────────────────────────────────────────
# 1. CRIAR OS GRUPOS
# ─────────────────────────────────────────
for grupo in ti rh admin secretarios estagiarios; do
    groupadd $grupo
done

# ─────────────────────────────────────────
# 2. CRIAR 20 USUÁRIOS POR GRUPO
# ─────────────────────────────────────────
grupos=("ti" "rh" "admin" "secretarios" "estagiarios")

for grupo in "${grupos[@]}"; do
    for i in $(seq 1 20); do
        usuario="${grupo}_user${i}"
        useradd -m -G $grupo $usuario
        echo "$usuario:senha123" | chpasswd
    done
done

# ─────────────────────────────────────────
# 3. CADA GRUPO TEM 5 ESTAGIÁRIOS
#    Eles pertencem ao grupo estagiarios + rh + ti
# ─────────────────────────────────────────
for i in $(seq 1 5); do
    usuario="estagiarios_user${i}"
    usermod -aG rh,ti $usuario
done

# ─────────────────────────────────────────
# 4. CRIAR ÁRVORE DE DIRETÓRIOS
# ─────────────────────────────────────────
mkdir -p /geral/publico
mkdir -p /geral/TI
mkdir -p /geral/Gerencia
mkdir -p /geral/rh
mkdir -p /geral/administrativo

# ─────────────────────────────────────────
# 5. PERMISSÕES
# ─────────────────────────────────────────

# Todos têm total acesso ao diretório público
chmod 777 /geral/publico

# Cada diretório de grupo: dono rwx, grupo r-x, outros ---
# Usuários do grupo conseguem visualizar/ler, mas não escrever
# Escrita só pelo dono (criador do arquivo)
chmod 750 /geral/TI
chown root:ti /geral/TI

chmod 750 /geral/rh
chown root:rh /geral/rh

chmod 750 /geral/Gerencia
chown root:admin /geral/Gerencia

chmod 750 /geral/administrativo
chown root:secretarios /geral/administrativo

# ─────────────────────────────────────────
# 6. CRIAR USUÁRIO ADMINISTRADOR NO GRUPO ROOT
# ─────────────────────────────────────────
useradd -m -G root administrador
echo "administrador:admin123" | chpasswd

echo "✅ Configuração concluída com sucesso!"
