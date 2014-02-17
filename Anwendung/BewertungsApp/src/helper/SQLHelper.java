package helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.MySqlAdapter;

public class SQLHelper {
	// Singleton
	private static SQLHelper sqlHelper = null;

	public SQLHelper() {
	}

	public static SQLHelper getInstance() {
		if (sqlHelper == null)
			sqlHelper = new SQLHelper();
		return sqlHelper;
	}

	// Field of the pupil id
	private int pupilId;

	public int getPupilId() {
		return this.pupilId;
	}

	// Method to set the pupil id if it not exists
	public void setPupilIdIfNotExists(String username, String password)
			throws Exception {
		if (this.pupilId == 0) {
			if (this.mySqlAdapter.isConnected()) {
				// Get first name and last name
				String[] names = username.split(".");
				// Query to get the entered pupil
				String query = "SELECT id,passwort FROM t_schueler WHERE "
						+ "vname=" + names[1] + " AND nname=" + names[0] + ";";

				ResultSet result = this.mySqlAdapter.returnQuery(query);
				if (result != null) {
					try {
						if (result.getString("passwort") == password) {
							// Set the get the id of the pupil
							this.pupilId = result.getInt("ID");
						} else {
							throw new Exception("Passwort ist falsch!");
						}
					} catch (SQLException e) {
						throw e;
					}
				} else {
					throw new Exception("Username is falsch!");
				}
			} else {
				throw new Exception("Zu keiner Datenbank verbunden!");
			}
		}
	}

	// Field of the teacher id
	private int teacherId;

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	// Field of the subject id
	private int subjectId;

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	private MySqlAdapter mySqlAdapter = new MySqlAdapter();

	// Method to get all teachers by a pupil id
	public ResultSet getAllTeachersOfTheCurrentPupil() {
		if (this.mySqlAdapter.isConnected()) {
			String query = "select distinct l.id, l.vname, l.nname "
					+ "from t_ergebnis join t_schueler s on fk_schueler = s.id "
					+ "join t_lehrer l on fk_lehrer = l.id where s.id = "
					+ this.pupilId + ";";

			return this.mySqlAdapter.returnQuery(query);
		} else {
			return null;
		}
	}

	// Method to get all teachers by a teacher id and a pupil id
	public ResultSet getAllSubjectsByCurrentPupilAndTeacherId(int teacherId) {
		if (this.mySqlAdapter.isConnected()) {
			String query = "select distinct f.id, f.kurz_bez from t_ergebnis "
					+ "join t_schueler s on fk_schueler = s.id "
					+ "join t_lehrer l on fk_lehrer = l.id "
					+ "join t_fach f on fk_fach = f.id where s.id = "
					+ this.pupilId + " and l.id=" + teacherId + ";";

			return this.mySqlAdapter.returnQuery(query);
		} else {
			return null;
		}
	}

}
