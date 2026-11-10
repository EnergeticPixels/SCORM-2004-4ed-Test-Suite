## Phase 1 P1-04 Runtime Execution Workbook (2026-10-09)

Status: In Progress
Version: 1.0
Backlog Item: P1-04
Source matrix: [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md)
Schema: [phase1_p1-07_baseline_artifact_schema_storage_v1.md](phase1_p1-07_baseline_artifact_schema_storage_v1.md)

### Objective
Execute baseline runtime flows and capture evidence for each matrix case into pre-created run folders.

### Quick Execution Checklist (per case)
1. Launch entry point in browser.
1. Execute case procedure from P1-01.
1. Capture start screenshot as `screenshot_start.png`.
1. Capture end screenshot as `screenshot_end.png`.
1. Save/export relevant runtime log as `summary_log.txt`.
1. Update `metadata.json` fields: timestamp_utc, workspace_commit, browser, baseline_class, result.
1. Update `notes.md` with observations and variance notes.
1. Add one row to [evidence index CSV](evidence/phase1/index/phase1_evidence_index.csv).

### Case-to-Run Folder Mapping
| Case ID | Group | Run ID | Evidence Folder |
|---|---|---|---|
| BL-LMS-01 | LMS | P1-04_LMS_BL-LMS-01_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/LMS/P1-04_LMS_BL-LMS-01_20261009_ENERG) |
| BL-LMS-02 | LMS | P1-04_LMS_BL-LMS-02_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/LMS/P1-04_LMS_BL-LMS-02_20261009_ENERG) |
| BL-LMS-03 | LMS | P1-04_LMS_BL-LMS-03_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/LMS/P1-04_LMS_BL-LMS-03_20261009_ENERG) |
| BL-SCO-01 | SCO | P1-04_SCO_BL-SCO-01_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/SCO/P1-04_SCO_BL-SCO-01_20261009_ENERG) |
| BL-SCO-02 | SCO | P1-04_SCO_BL-SCO-02_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/SCO/P1-04_SCO_BL-SCO-02_20261009_ENERG) |
| BL-CP-01 | CP | P1-04_CP_BL-CP-01_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/CP/P1-04_CP_BL-CP-01_20261009_ENERG) |
| BL-CP-02 | CP | P1-04_CP_BL-CP-02_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/CP/P1-04_CP_BL-CP-02_20261009_ENERG) |
| BL-CP-03 | CP | P1-04_CP_BL-CP-03_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/CP/P1-04_CP_BL-CP-03_20261009_ENERG) |
| BL-MAN-01 | MAN | P1-04_MAN_BL-MAN-01_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/MAN/P1-04_MAN_BL-MAN-01_20261009_ENERG) |
| BL-MAN-02 | MAN | P1-04_MAN_BL-MAN-02_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/MAN/P1-04_MAN_BL-MAN-02_20261009_ENERG) |
| BL-MAN-03 | MAN | P1-04_MAN_BL-MAN-03_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/MAN/P1-04_MAN_BL-MAN-03_20261009_ENERG) |
| BL-CHK-01 | CHK | P1-04_CHK_BL-CHK-01_20261009_ENERG | [run folder](evidence/phase1/runtime/P1-04/CHK/P1-04_CHK_BL-CHK-01_20261009_ENERG) |

### Suggested Run Order
1. BL-LMS-01
1. BL-SCO-01
1. BL-CP-01
1. BL-MAN-01
1. BL-CHK-01 (optional sentinel)
1. Remaining variance/error-path cases

### Run Log
- [ ] BL-LMS-01 completed
- [ ] BL-LMS-02 completed
- [ ] BL-LMS-03 completed
- [ ] BL-SCO-01 completed
- [ ] BL-SCO-02 completed
- [X] BL-CP-01 completed — attempted 2026-10-09, **blocked** (Baseline Class C: Edge legacy-browser warning; no Java browser plugin runtime). See [run folder](evidence/phase1/runtime/P1-04/CP/P1-04_CP_BL-CP-01_20261009_ENERG).
- [ ] BL-CP-02 completed
- [ ] BL-CP-03 completed
- [ ] BL-MAN-01 completed
- [ ] BL-MAN-02 completed
- [ ] BL-MAN-03 completed
- [ ] BL-CHK-01 completed

### Notes
- Self-signed jar warnings in build output are expected for local baseline signing.
- Use baseline class labels (A/B/C) from P1-01 in each run metadata.
- 2026-11-10: BL-CP-01 attempt confirmed modern Edge cannot load the Java applet plugin; expect the same Class C blocker on all applet-driven cases until a legacy-capable environment is available (see P1-01 acquisition order).
