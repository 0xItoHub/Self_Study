`ORACLE_DATAPUMP` アクセスドライバを使用して外部表を作成する際、`TYPE` 句では主に2つの選択肢があります。これらは、外部表に使用するアクセスドライバの種類を指定するためのオプションです。

### 1. **`TYPE ORACLE_DATAPUMP`**
   - **用途**: データポンプ（Data Pump）形式のファイルを外部表として扱う場合に使用されます。
   - **特徴**: データポンプ形式のファイルは、通常エクスポートやインポートで使用される高速なバイナリ形式です。この形式を使用すると、データベース内のデータを外部ファイルに出力したり、逆に外部ファイルからデータベースに読み込むことができます。

   **使用例**:
   ```sql
   CREATE TABLE external_table_name
   (
     column1 NUMBER,
     column2 VARCHAR2(50)
   )
   ORGANIZATION EXTERNAL
   (
     TYPE ORACLE_DATAPUMP
     DEFAULT DIRECTORY data_pump_dir
     LOCATION ('export_file.dmp')
   )
   REJECT LIMIT UNLIMITED;
   ```

### 2. **`TYPE ORACLE_LOADER`**
   - **用途**: テキストファイル（CSVやTSVなど）を外部表として扱う場合に使用されます。
   - **特徴**: `ORACLE_LOADER` ドライバは、テキスト形式のデータをロードするために使用され、通常はコンマ区切りやタブ区切りなどの形式で保存されたデータファイルに対してクエリを実行することができます。このアクセスドライバは、データの読み込みに特化しています。

   **使用例**:
   ```sql
   CREATE TABLE external_table_name
   (
     column1 NUMBER,
     column2 VARCHAR2(50)
   )
   ORGANIZATION EXTERNAL
   (
     TYPE ORACLE_LOADER
     DEFAULT DIRECTORY data_dir
     ACCESS PARAMETERS
     (
       RECORDS DELIMITED BY NEWLINE
       FIELDS TERMINATED BY ','
       OPTIONALLY ENCLOSED BY '"'
     )
     LOCATION ('data_file.csv')
   )
   REJECT LIMIT UNLIMITED;
   ```

### 選択肢のまとめ

- **`ORACLE_DATAPUMP`**: データポンプ形式のバイナリファイルを使用する場合。主にデータのエクスポート/インポートに使われます。
- **`ORACLE_LOADER`**: テキストファイル（CSVなど）のデータを読み込む場合に使用。テキスト形式のファイルからデータをロードするために適しています。

使用する形式は、扱うデータの種類や用途に応じて選択します。
