INSERT INTO eleve (
    id,
    lieunaissance,
    birthday,
    datedelivrance,
    matricule,
    nom,
    numerocni,
    password,
    prenom,
    sexe,
    statuseleve
  )
VALUES (
    'id:bigint',
    'lieunaissance:character varying',
    'birthday:timestamp without time zone',
    'datedelivrance:timestamp without time zone',
    'matricule:character varying',
    'nom:character varying',
    'numerocni:character varying',
    'password:character varying',
    'prenom:character varying',
    'sexe:smallint',
    'statuseleve:smallint'
  );