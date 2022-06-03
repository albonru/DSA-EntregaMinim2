# EJ5

Nueva funcionalidad que permita realizar una consulta sobre la aplicación.
  - T1. En la App Android, añadir una nueva actividad que proporcione un pequeño formulario para solicitar y enviar información sobre un tema
  - T2. Nueva ruta en el backend que reciba la nueva consulta

Comentaris:
  - Hi ha una branca frontend (app) i una backend (server) del projecte amb la nova funcionalitat implementada
  - No s'arriba a guardar a la BBDD, caldria crear una estructura per a questions
  - S'han testejat les dues parts tant per separat com juntes
  - Modificacions a frontend: Question, QuestionActivity, activity_question layout + petita modificació a MenuActivity i ApiService
  - Modificacions a backend: Question, QuestionDAO, QuestionDAOImpl, QuestionService
