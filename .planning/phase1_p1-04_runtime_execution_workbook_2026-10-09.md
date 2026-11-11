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
- [X] BL-LMS-01 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-LMS-02 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-LMS-03 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-SCO-01 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-SCO-02 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-CP-01 completed — attempted 2026-10-09, **blocked** (Baseline Class C: Edge legacy-browser warning; no Java browser plugin runtime). See [run folder](evidence/phase1/runtime/P1-04/CP/P1-04_CP_BL-CP-01_20261009_ENERG).
- [X] BL-CP-02 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-CP-03 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-MAN-01 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-MAN-02 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-MAN-03 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).
- [X] BL-CHK-01 completed — bulk-marked 2026-11-10 as **blocked** (Baseline Class C, cross-referenced to BL-CP-01 environment blocker evidence; no per-case interactive execution in this pass).

### Legacy Pilot Checklist (Next Session)
- [X] Confirm legacy-capable runtime source per P1-01 acquisition order (internal VM snapshot, offline media, or nearest applet-capable fallback) and record provenance.
- [X] Record environment metadata before rerun: OS build, browser version, JRE/JDK version, and source/provenance.
- [ ] Re-run BL-CP-01 in the legacy-capable environment and replace provisional blocker evidence with case-specific runtime evidence.
- [ ] Capture required artifacts in `P1-04_CP_BL-CP-01_20261009_ENERG`: `screenshot_start.png`, `screenshot_end.png`, `summary_log.txt`, updated `metadata.json`, updated `notes.md`.
- [ ] Determine resulting baseline class for BL-CP-01 (A/B/C) and document rationale.
- [ ] If BL-CP-01 succeeds in Class A/B, rerun BL-LMS-01, BL-SCO-01, and BL-MAN-01 next to begin replacing bulk-marked Class C entries.

### Legacy Pilot Session Record (Fill In)
- Pilot date (UTC): `2026-11-11T19:32:48Z`
- Pilot runner: `energ`
- Runtime source/provenance: `VirtualBox guest setup attempt (Windows 7 SP1 path) investigated; no usable legacy IE + Java plugin combination could be established due retired/blocked vendor distribution and support paths.`
- Host/VM details: `Host: Windows 11 Pro 23H2; Guest target: Windows 7 SP1 (VirtualBox 7.0), not brought to runnable legacy applet state`
- OS version/build: `Host Windows 11 Pro 23H2; legacy guest runtime not validated`
- Browser product/version: `N/A for pilot rerun (legacy-capable browser not successfully provisioned); host browser Microsoft Edge 157`
- JRE/JDK product/version: `N/A for legacy browser plugin runtime (not successfully provisioned)`
- BL-CP-01 outcome: `blocked` (pass/fail/blocked)
- Baseline class result: `C` (A/B/C)
- Decision after pilot: `remain provisional C` (promote to LMS/SCO/MAN reruns or remain provisional C)
- Notes: `Pilot blocked at environment provisioning stage; no interactive BL-CP-01 legacy rerun executed. Keep existing Class C evidence set and revisit only if a sanctioned internal legacy image becomes available.`

### Notes
- 2026-11-10: Fast Class C sweep performed for remaining cases by cross-reference to BL-CP-01 blocker evidence. Entries are documented as bulk-marked and require per-case rerun once legacy-capable runtime is available.
- 2026-11-11: Legacy pilot provisioning investigation concluded no usable legacy IE + Java plugin environment is currently achievable on available setup path; BL-CP-01 rerun remains blocked and Phase 1 stays provisional Class C.
- Self-signed jar warnings in build output are expected for local baseline signing.
- Use baseline class labels (A/B/C) from P1-01 in each run metadata.
- 2026-11-10: BL-CP-01 attempt confirmed modern Edge cannot load the Java applet plugin; expect the same Class C blocker on all applet-driven cases until a legacy-capable environment is available (see P1-01 acquisition order).



