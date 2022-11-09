{{- define "common.fullname" -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- end -}}

{{- define "common.name" -}}
    {{ .Chart.Name }}
{{- end }}