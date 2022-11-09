{{- define "common.service" -}}

{{- $common := dict "Values" .Values.common -}} # Values з common Chart
{{- $noCommon := omit .Values "common" -}} # Values з основного Chart
{{- $overrides := dict "Values" $noCommon -}} # записуємо common Values в змінну Values
{{- $noValues := omit . "Values" -}} # містить усе крім Values, зокрема Chart, Release
{{- with merge $noValues $overrides $common -}}
---
apiVersion: v1
kind: Service
metadata:
  name: {{ include "common.name" . }}
spec:
  type: ClusterIP
  ports:
    {{- range .Values.service.ports }}
    - name: {{ .name }}
      port: {{ .port }}
      targetPort: {{ .targetPort }}
    {{- end }}
  selector:
    app: {{ include "common.name" . }}-pod
{{ end }}
{{- end -}}