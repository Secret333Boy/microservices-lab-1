{{/*
Імʼя. Обрізається до 63-х символів, через обмеження Kubernetes. `nameOverride` дозволяє перевизначати імʼя.
*/}}

{{- define "common.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{- define "common.ingress" -}}
apiVersion: networking.k8s.io/v1
kind: Ingress
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

