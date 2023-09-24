DELETE FROM db_appl_poi.dados_posicao WHERE dados_posicao.placa IN ("TESTE001", "CAR0012");
DELETE FROM db_appl_poi.veiculo WHERE veiculo.placa IN ("TESTE001", "CAR0012");
INSERT INTO db_appl_poi.veiculo (placa,marca,modelo) VALUES ("TESTE001","FIAT","STRADA");
INSERT INTO db_appl_poi.veiculo (placa,marca,modelo) VALUES ("CAR0012","FIAT","ARGO");