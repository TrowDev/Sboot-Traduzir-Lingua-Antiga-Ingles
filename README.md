# Explicação:
Este projeto foi feito em Java 11+ mediante a um desafio técnico apresentado por uma consultoria. A ideia é testar a lógica, forma de programar, padrões de código, design patterns, clean code e etc.
<hr>

# DESAFIO:
## Contexto
<p>Uma linguagem antiga, que parece ser um derivado próximo do inglês, foi descoberta recentemente por pesquisadores. Um grupo dos pesquisadores requer um programa para traduzir o inglês para o texto antigo. O desafio é escrever um simples programa para realizar a tradução básica do inglês para a língua estrangeira.</p>

## Regras
<p>
1° Se a palavra não tem letras, não deve ser traduzida.<br>
2° Todas as pontuações devem ser preservadas.<br>
3° Se a palavra começa com letra maiúscula, a palavra traduzida deve manter-se da mesma forma.<br>
4° Separe cada palavra em 2 partes. A primeira parte, chamado de "prefix", deve ir do início da palavra até, mas não incluir, a primeira vogal. O restante da palavra é chamado de "stem".<br>
<b>Obs: Considerar a letra "y" como vogal</b><br>
5° O texto traduzido é formado pelo reverso do prefixo com o stem e adicionando as letras <b>"ay"</b> no final da palavra invertida. (Ex: Sandwich, S <b>[prefixo]</b> + andwich <b>[stem]</b> . Invertemos ficando: Andwich + S + "ay", formando: Andwichsay).<br>
6° Se a palavra não tiver nenhuma consoante, deixe o prefixo vazio e a palavra será considerada por completo como "stem". No final da palavra deverá ser adicionado o termo "yay", ao invés de "ay". (Ex: I, deve ser traduzido como Iyay).<br>
</p>

## Exemplos:
Entrada | Saida
--- | --- 
Stop | Opstay
No littering | Onay itteringlay
No shirts, no shoes, no service | Onay irtsshay, onay oesshay, onay ervicesay.
No persons under 14 admitted | Onay ersonspay underay 14 admitteday.
Hey buddy, get away from my car! | Eyhay uddybay, etgay awayay omfray ymay arcay!