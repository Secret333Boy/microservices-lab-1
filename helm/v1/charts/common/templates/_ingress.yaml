{{- define "common.ingress" -}}

{{- $common := dict "Values" .Values.common -}} # Values з common Chart
{{- $noCommon := omit .Values "common" -}} # Values з основного Chart
{{- $overrides := dict "Values" $noCommon -}} # записуємо common Values в змінну Values
{{- $noValues := omit . "Values" -}} # містить усе крім Values, зокрема Chart, Release
{{- with merge $noValues $overrides $common -}}
---
{{ include "common.ingress" . }}
{{- end -}}
{{- end -}}