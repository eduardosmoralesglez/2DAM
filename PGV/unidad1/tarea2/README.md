# Tarea 2

## Preparación

### Eduardo Serafín Morales González

Crea tu área de trabajo y variables útiles:

```bash
mkdir -p ~/dam/{bin,logs,units}
export DAM=~/dam
echo 'export DAM=~/dam' >> ~/.bashrc
```

Comprobar versión de systemd y que el *user manager* está activo:

```bash
systemctl --user --version | head -n1
systemctl --user status --no-pager | head -n5
```
**Pega salida aquí:**

```text
 dam  ~  mkdir -p ~/dam/{bin,logs,units}
 dam  ~  export DAM=~/dam
 dam  ~  echo 'export DAM=~/dam' >> ~/.bashrc
 dam  ~  
 dam  ~  systemctl --user --version | head -n1
systemd 255 (255.4-1ubuntu8.6)
 dam  ~  systemctl --user status --no-pager | head -n5
● a108pc21
    State: running
    Units: 291 loaded (incl. loaded aliases)
     Jobs: 0 queued
   Failed: 0 units
 dam  ~  SIGPIPE  0  

```

**Reflexiona la salida:**

```text

```

---

## Bloque 1 — Conceptos (breve + fuentes)

1) ¿Qué es **systemd** y en qué se diferencia de SysV init?  

**Respuesta:**  systemd es el demonio administrador del sistema, es el padre de todos los procesos, siendo el primero que se ejecuta despues del kernel.

systemd es una alternativa a SysV init, systemd fue diseñado para suplir las carencias de init. Una de las grandes diferencias de systemd con respecto a init es el inicio en paralelo, lo que confiere a systemd una reduccion de los tiempos de arranque y de la sobrecarga computacional.

_Fuentes:_ http://sudo.es/docnux/sysinit_director/systemd_vs_init.pdf

2) **Servicio** vs **proceso** (ejemplos).  

**Respuesta:**  Un servicio es un programa del sistema que proporciona una funcionalidad al sistema y un proceso es una instancia de un programa que utiliza recursos del sistema, asignado a un PID(ID del Proceso)

_Fuentes:_

3) ¿Qué son los **cgroups** y para qué sirven?  

**Respuesta:** Los cgroups son una herramienta de control de recursos, permite dividir o ajustar los recursos del sistema, por ejemplo:

Si tenemos instalado en nuestro sistema Apache, y queremos que independientemente de los procesos que tenga, disponga del 50% de la capacidad total del CPU, los cgroups nos permiten hacelo.

_Fuentes:_ https://elpuig.xeill.net/Members/vcarceler/articulos/introduccion-a-los-grupos-de-control-cgroups-de-linux

4) ¿Qué es un **unit file** y tipos (`service`, `timer`, `socket`, `target`)?  

**Respuesta:**  Son los ficheros de configuración del sistema, son los encargados de describir y definir como funcionan los recursos del sistema

_Fuentes:_

5) ¿Qué hace `journalctl` y cómo ver logs **de usuario**?  

**Respuesta:**  Es un comando para consultar o gestionar registros del sistema, los logs, 

_Fuentes:_

---

## Bloque 2 — Práctica guiada (todo en tu `$DAM`)

> Si un comando pide permisos que no tienes, usa la **versión `--user`** o consulta el **ayuda** con `--help` para alternativas.

### 2.1 — PIDs básicos

**11.** PID de tu shell y su PPID.

```bash
echo "PID=$$  PPID=$PPID"
```
**Salida:**

```text
PID=27829 PPID=23366
```

**Pregunta:** ¿Qué proceso es el padre (PPID) de tu shell ahora?  

**Respuesta:**

---

**12.** PID del `systemd --user` (manager de usuario) y explicación.

```bash
pidof systemd --user || pgrep -u "$USER" -x systemd
```

**Salida:**

```text
3388
```
**Pregunta:** ¿Qué hace el *user manager* de systemd para tu sesión?  

**Respuesta:**

---

### 2.2 — Servicios **de usuario** con systemd

Vamos a crear un servicio sencillo y un timer **en tu carpeta** `~/.config/systemd/user` o en `$DAM/units` (usaremos la primera para que `systemctl --user` lo encuentre).

**13.** Prepara directorios y script de práctica.

```bash
mkdir -p ~/.config/systemd/user "$DAM"/{bin,logs}
cat << 'EOF' > "$DAM/bin/fecha_log.sh"
#!/usr/bin/env bash
mkdir -p "$HOME/dam/logs"
echo "$(date --iso-8601=seconds) :: hello from user timer" >> "$HOME/dam/logs/fecha.log"
EOF
chmod +x "$DAM/bin/fecha_log.sh"
```

**14.** Crea el servicio **de usuario** `fecha-log.service` (**Type=simple**, ejecuta tu script).

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.service
[Unit]
Description=Escribe fecha en $HOME/dam/logs/fecha.log

[Service]
Type=simple
ExecStart=%h/dam/bin/fecha_log.sh
EOF

systemctl --user daemon-reload
systemctl --user start fecha-log.service
systemctl --user status fecha-log.service --no-pager -l | sed -n '1,10p'
```
**Salida (pega un extracto):**

```text
Failed to dump process list for 'fecha-log.service', ignoring: Unit fecha-log.service not loaded.
● fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log
     Loaded: loaded (/home/dam/.config/systemd/user/fecha-log.service; static)
     Active: active (running) since Wed 2025-09-24 16:28:02 WEST; 8ms ago
   Main PID: 18644 (bash)
      Tasks: 2 (limit: 37621)
     Memory: 716.0K (peak: 940.0K)
        CPU: 3ms
     CGroup: /user.slice/user-1001.slice/user@1001.service/app.slice/fecha-log.service

sep 24 16:28:02 a108pc21 systemd[3458]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
 dam  ~  
```
**Pregunta:** ¿Se creó/actualizó `~/dam/logs/fecha.log`? Muestra las últimas líneas:

```bash
tail -n 5 "$DAM/logs/fecha.log"
```

**Salida:**

```text
 dam  ~  SIGINT  tail -n 5 "$DAM/logs/fecha.log"
2025-09-24T16:28:02+01:00 :: hello from user timer
 dam  ~  
```

**Reflexiona la salida:**

```text

```

---

**15.** Diferencia **enable** vs **start** (modo usuario). Habilita el **timer**.

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.timer
[Unit]
Description=Timer (usuario): ejecuta fecha-log.service cada minuto

[Timer]
OnCalendar=*:0/1
Unit=fecha-log.service
Persistent=true

[Install]
WantedBy=timers.target
EOF

systemctl --user daemon-reload
systemctl --user enable --now fecha-log.timer
systemctl --user list-timers --all | grep fecha-log || true
```

**Salida (recorta):**

```text
Created symlink /home/dam/.config/systemd/user/timers.target.wants/fecha-log.timer → /home/dam/.config/systemd/user/fecha-log.timer.
Wed 2025-09-24 16:30:00 WEST   4s -                                    - fecha-log.timer                fecha-log.service
 dam  ~  

```
**Pregunta:** ¿Qué diferencia hay entre `enable` y `start` cuando usas `systemctl --user`?  

**Respuesta:** 

---

**16.** Logs recientes **del servicio de usuario** con `journalctl --user`.

```bash
journalctl --user -u fecha-log.service -n 10 --no-pager
```

**Salida:**

```text
 dam  ~  journalctl --user -u fecha-log.service -n 10 --no-pager
sep 24 16:28:02 a108pc21 systemd[3458]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 24 16:30:33 a108pc21 systemd[3458]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
 dam  ~  
```
**Pregunta:** ¿Ves ejecuciones activadas por el timer? ¿Cuándo fue la última?  

**Respuesta:** Se ven 2 ejecuciones del fechas.log, el 24 sep a las 4:26 y 4:30

---

### 2.3 — Observación de procesos sin root

**17.** Puertos en escucha (lo que puedas ver como usuario).

```bash
lsof -i -P -n | grep LISTEN || ss -lntp
```
**Salida:**

```text
 dam  ~  lsof -i -P -n | grep LISTEN || ss -lntp
adb        9993  dam   11u  IPv4  53943      0t0  TCP 127.0.0.1:5037 (LISTEN)
java      16908  dam  110u  IPv6  63398      0t0  TCP 127.0.0.1:43661 (LISTEN)
 dam  ~  
```
**Pregunta:** ¿Qué procesos *tuyos* están escuchando? (si no hay, explica por qué)  

**Respuesta:** adb y java estan escuchando

---

**18.** Ejecuta un proceso bajo **cgroup de usuario** con límite de memoria.

```bash
systemd-run --user --scope -p MemoryMax=50M sleep 200
ps -eo pid,ppid,cmd,stat | grep "[s]leep 200"
```

**Salida:**

```text
Running as unit: run-rf7189112d83a4d3c8f1221601d1c4f1e.scope; invocation ID: 47eae83301584d0cba0273ea26d5e4ea

```
**Pregunta:** ¿Qué ventaja tiene lanzar con `systemd-run --user` respecto a ejecutarlo “a pelo”?  

**Respuesta:** 

---

**19.** Observa CPU en tiempo real con `top` (si tienes `htop`, también vale).

```bash
top -b -n 1 | head -n 15
```
**Salida (resumen):**

```text
top - 16:34:17 up 33 min,  1 user,  load average: 0,30, 0,52, 0,62
Tareas: 407 total,   2 ejecutar,  405 hibernar,    0 detener,    0 zombie
%Cpu(s):  0,0 us,  0,7 sy,  0,0 ni, 98,0 id,  1,3 wa,  0,0 hi,  0,0 si,  0,0 st 
MiB Mem :  31453,3 total,  24494,4 libre,   4382,0 usado,   3067,1 búf/caché    
MiB Intercambio:   2048,0 total,   2048,0 libre,      0,0 usado.  27071,2 dispon

    PID USUARIO   PR  NI    VIRT    RES    SHR S  %CPU  %MEM     HORA+ ORDEN
  21490 dam       20   0   17224   5760   3584 R   9,1   0,0   0:00.02 top
      1 root      20   0   23436  14152   9288 S   0,0   0,0   0:01.46 systemd
      2 root      20   0       0      0      0 S   0,0   0,0   0:00.00 kthreadd
      3 root      20   0       0      0      0 S   0,0   0,0   0:00.00 pool_wo+
      4 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      5 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      6 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      7 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
```
**Pregunta:** ¿Cuál es tu proceso con mayor `%CPU` en ese momento?  

**Respuesta:** El proceso top de mi usuario dam

---

**20.** Traza syscalls de **tu propio proceso** (p. ej., el `sleep` anterior).
> Nota: Sin root, no podrás adjuntarte a procesos de otros usuarios ni a algunos del sistema.

```bash
pid=$(pgrep -u "$USER" -x sleep | head -n1)
strace -p "$pid" -e trace=nanosleep -tt -c -f 2>&1 | sed -n '1,10p'
```

**Salida (fragmento):**

```text

```
**Pregunta:** Explica brevemente la syscall que observaste.  

**Respuesta:**

---

### 2.4 — Estados y jerarquía (sin root)

**21.** Árbol de procesos con PIDs.

```bash
pstree -p | head -n 50
```

**Salida (recorta):**

```text
systemd(1)-+-ModemManager(1861)-+-{ModemManager}(1871)
           |                    |-{ModemManager}(1873)
           |                    `-{ModemManager}(1875)
           |-NetworkManager(1834)-+-{NetworkManager}(1866)
           |                      |-{NetworkManager}(1867)
           |                      `-{NetworkManager}(1868)
           |-accounts-daemon(1184)-+-{accounts-daemon}(1211)
           |                       |-{accounts-daemon}(1212)
           |                       `-{accounts-daemon}(1830)
           |-agetty(2281)
           |-apache2(2357)-+-apache2(2375)
           |               |-apache2(2376)
           |               |-apache2(2377)
           |               |-apache2(2378)
           |               `-apache2(2379)
           |-at-spi2-registr(3813)-+-{at-spi2-registr}(3818)
           |                       |-{at-spi2-registr}(3819)
           |                       `-{at-spi2-registr}(3820)
           |-avahi-daemon(1186)---avahi-daemon(1272)
           |-blkmapd(1175)
           |-colord(2029)-+-{colord}(2036)
           |              |-{colord}(2037)
           |              `-{colord}(2039)
           |-containerd(2006)-+-{containerd}(2031)
           |                  |-{containerd}(2032)
           |                  |-{containerd}(2033)
           |                  |-{containerd}(2034)
           |                  |-{containerd}(2035)
           |                  |-{containerd}(2057)
           |                  |-{containerd}(2058)
           |                  |-{containerd}(2059)
           |                  |-{containerd}(2070)
           |                  |-{containerd}(2071)
           |                  |-{containerd}(2077)
           |                  |-{containerd}(2078)
           |                  `-{containerd}(2079)
           |-containerd-shim(3256)-+-apache2(3279)-+-apache2(3391)
           |                       |               |-apache2(3392)
           |                       |               |-apache2(3393)
           |                       |               |-apache2(3394)
           |                       |               `-apache2(3395)
           |                       |-{containerd-shim}(3257)
           |                       |-{containerd-shim}(3258)
           |                       |-{containerd-shim}(3259)
           |                       |-{containerd-shim}(3260)
           |                       |-{containerd-shim}(3261)
           |                       |-{containerd-shim}(3262)
           |                       |-{containerd-shim}(3263)
           |                       |-{containerd-shim}(3264)
           |                       |-{containerd-shim}(3265)
```
**Pregunta:** ¿Bajo qué proceso aparece tu `systemd --user`?  

**Respuesta:**

---

**22.** Estados y relación PID/PPID.

```bash
ps -eo pid,ppid,stat,cmd | head -n 20
```
**Salida:**

```text
    PID    PPID STAT CMD
      1       0 Ss   /sbin/init splash
      2       0 S    [kthreadd]
      3       2 S    [pool_workqueue_release]
      4       2 I<   [kworker/R-rcu_g]
      5       2 I<   [kworker/R-rcu_p]
      6       2 I<   [kworker/R-slub_]
      7       2 I<   [kworker/R-netns]
      8       2 I    [kworker/0:0-events]
     10       2 I<   [kworker/0:0H-events_highpri]
     12       2 I<   [kworker/R-mm_pe]
     13       2 I    [rcu_tasks_kthread]
     14       2 I    [rcu_tasks_rude_kthread]
     15       2 I    [rcu_tasks_trace_kthread]
     16       2 S    [ksoftirqd/0]
     17       2 I    [rcu_preempt]
     18       2 S    [migration/0]
     19       2 S    [idle_inject/0]
     20       2 S    [cpuhp/0]
     21       2 S    [cpuhp/1]
```
**Pregunta:** Explica 3 flags de `STAT` que veas (ej.: `R`, `S`, `T`, `Z`, `+`).  

**Respuesta:**

---

**23.** Suspende y reanuda **uno de tus procesos** (no crítico).

```bash
# Crea un proceso propio en segundo plano
sleep 120 &
pid=$!
# Suspende
kill -STOP "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
# Reanuda
kill -CONT "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
```
**Pega los dos estados (antes/después):**

```text
[1] 27460

[1]+  Detenido                sleep 120
    PID STAT CMD
  27460 T    bash
    PID STAT CMD
  27460 S    sleep 120

```
**Pregunta:** ¿Qué flag indicó la suspensión?  

**Respuesta:**

---

**24. (Opcional)** Genera un **zombie** controlado (no requiere root).

```bash
cat << 'EOF' > "$DAM/bin/zombie.c"
#include <stdlib.h>
#include <unistd.h>
int main() {
  if (fork() == 0) { exit(0); } // hijo termina
  sleep(60); // padre no hace wait(), hijo queda zombie hasta que padre termine
  return 0;
}
EOF
gcc "$DAM/bin/zombie.c" -o "$DAM/bin/zombie" && "$DAM/bin/zombie" &
ps -el | grep ' Z '
```
**Salida (recorta):**

```text
[2] 27730
```
**Pregunta:** ¿Por qué el estado `Z` y qué lo limpia finalmente?  

**Respuesta:**

---

### 2.5 — Limpieza (solo tu usuario)

Detén y deshabilita tu **timer/servicio de usuario** y borra artefactos si quieres.

```bash
systemctl --user disable --now fecha-log.timer
systemctl --user stop fecha-log.service
rm -f ~/.config/systemd/user/fecha-log.{service,timer}
systemctl --user daemon-reload
rm -rf "$DAM/bin" "$DAM/logs" "$DAM/units"
```

```text
Removed "/home/dam/.config/systemd/user/timers.target.wants/fecha-log.timer".
'/home/dam/.config/systemd/user/fecha-log.service' borrado
'/home/dam/.config/systemd/user/fecha-log.timer' borrado
'/home/dam/dam/bin/zombie.c' borrado
'/home/dam/dam/bin/fecha_log.sh' borrado
'/home/dam/dam/bin/zombie' borrado
removed directory '/home/dam/dam/bin'
'/home/dam/dam/logs/fecha.log' borrado
removed directory '/home/dam/dam/logs'
removed directory '/home/dam/dam/units'
```
---

## ¿Qué estás prácticando?
- [ ] Pegaste **salidas reales**.  
- [ ] Explicaste **qué significan**.  
- [ ] Usaste **systemd --user** y **journalctl --user**.  
- [ ] Probaste `systemd-run --user` con límites de memoria.  
- [ ] Practicaste señales (`STOP`/`CONT`), `pstree`, `ps` y `strace` **sobre tus procesos**.

---

## Licencia 📄
Licencia **Apache 2.0** — ver [LICENSE.md](https://github.com/jpexposito/code-learn-practice/blob/main/LICENSE).