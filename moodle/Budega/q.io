>>>>>>>> inicializar
init 2
show
call 0
call 1
arrive joao
arrive maria
arrive ana
show
call 0
show
call 1
show
finish 1
show
call 1
show
finish 0
show
finish 1
show 
end
========
$init 2
$show
|0:-----|1:-----|
Espera: []
$call 0
fail: fila vazia
$call 1
fail: fila vazia
$arrive joao
$arrive maria
$arrive ana
$show
|0:-----|1:-----|
Espera: [joao, maria, ana]
$call 0
$show
|0:joao|1:-----|
Espera: [maria, ana]
$call 1
$show
|0:joao|1:maria|
Espera: [ana]
$finish 1
$show
|0:joao|1:-----|
Espera: [ana]
$call 1
$show
|0:joao|1:ana|
Espera: []
$finish 0
$show
|0:-----|1:ana|
Espera: []
$finish 1
$show 
|0:-----|1:-----|
Espera: []
$end
<<<<<<<<



