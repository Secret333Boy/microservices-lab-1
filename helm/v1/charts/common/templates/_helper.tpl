{{/*
Імʼя. Обрізається до 63-х символів, через обмеження Kubernetes. `nameOverride` дозволяє перевизначати імʼя.
*/}}
{{- define "common.name" -}}
    {{ .Chart.Name }}
{{- end }}

{{- define "common.ingress" -}}
metadata:
  name: {{ include "common.name" . }}-ingress
  annotations:
    kubernetes.io/ingress.class: "nginx"
spec:
  rules:
    - http:
        paths:
          - path: {{ .Values.ingress.mapping }}
            pathType: "Prefix"
            backend:
              service:
                name: {{ include "common.name" . }}
                port:
                  number: 80
{{- end }}

