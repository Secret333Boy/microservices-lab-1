{{- define "common.deployment" -}}

{{- $common := dict "Values" .Values.common -}} # Values з common Chart
{{- $noCommon := omit .Values "common" -}} # Values з основного Chart
{{- $overrides := dict "Values" $noCommon -}} # записуємо common Values в змінну Values
{{- $noValues := omit . "Values" -}} # містить усе крім Values, зокрема Chart, Release
{{- with merge $noValues $overrides $common -}}

---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ include "common.name" . }}-deployment
spec:
  replicas: {{ .Values.replicaCount }}
  selector:
    matchLabels:
      app: {{ include "common.name" . }}-pod
  template:
    metadata:
      labels:
        app: {{ include "common.name" . }}-pod
    spec:
      {{ $myChartName := include "common.name" . }}
      {{ if .Values.migrations }}
      initContainers:
        - name: {{ include "common.name" . }}-migration
          image: {{ .Values.migrations.image }}
          command: {{ .Values.migrations.command }}
          env:
            {{ range .Values.env }}
            - name: {{ .name }}
            {{ if and (.type) (eq .type "secret") }}
              valueFrom:
                secretKeyRef:
                  name: {{ include "common.name" $ }}-secret
                  key: {{ .value }}
            {{ else }}
              value: {{.value}}
            {{ end }}
            {{ end }}
      {{ end }}
      containers:
        - image: {{ .Values.image.name }}
          name: {{ include "common.name" . }}-container
          ports:
            - containerPort: {{ .Values.image.port }}
          env:
            {{ range .Values.env }}
            - name: {{ .name }}
            {{ if and (.type) (eq .type "secret") }}
              valueFrom:
                secretKeyRef:
                  name: {{ include "common.name" $ }}-secret
                  key: {{ .value }}
            {{ else }}
              value: {{.value}}
            {{ end }}
            {{ end }}
          resources:
            limits:
              memory: {{ .Values.resources.limits.memory }}
              cpu: {{ .Values.resources.limits.cpu }}
{{- end -}}
{{- end -}}
