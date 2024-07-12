# Data e Hora no Java
## Conceitos importantes
**Data-[hora] local:**
ano-mês-dia-[hora] sem fuso horário
hora é opcional

**Data-hora global:**
ano-mês-dia-hora com fuso horário

**Duração**:
Tempo decorrido entre duas data-hora

## Quando usar?
**Data-[hora] local**: Quando o momento exato não interesse a pessoas de outro fuso horário. Usos comuns: sistemas de região única, Excel.
data de nascimento: "29/02/2016"

**Data-hora global**: Quando o momento exato interessa a pessoas de outro fuso horário. Usos comuns: sistemas multi-região, web.
Quando será o sorteio? "14/04/2024 às 15h (horário de Brasilía)"
Quando o comentário foi postado? "Há 17 minutos"

## Timezone (fuso horário)
- GMT - Greenwich Mean Time
 - Horário de Londres
 - Horário do padrão UTC - Coordinated Universal Time
 - Também chamado de "Time Z" ou "Zulu Time"
- Outros fuso horários são relativos ao GMT:
 - São Paulo: GMT-3
 - Manaus: GMT-4
 - Portugal: GMT+1

## Padrão ISO 8601
Data-[hora] local:
2022-07-21 (data sem horário)
2022-07-21T16:05 (data com hora e minutos)
2022-07-21T16:05:45 (data, hora, minutos e segundos)
2022-07-21T16:05:45.0938 (acrescenta a fração de segundos)

Data-hora global:
2022-07-21T16:09:59Z (fuso horário de londres)
2022-07-21T16:09:59-03:00 (fuso GMT-3)

## Principais tipos Java (versão 8+)
- Data-hora local: _LocalDate_, _LocalDateTime_
- Data-hora global: _Instant_
- Duração: _Duration_
- Outros: _Zoneld_, _ChronoUnit_